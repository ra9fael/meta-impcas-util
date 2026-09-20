SUMMARY = "C.UTF-8 binary locale for the target glibc"
DESCRIPTION = "PetaLinux clears IMAGE_LINGUAS, so no locale data is shipped \
and LANG=C.UTF-8 cannot be resolved by setlocale() (ENOENT), which breaks \
btop and spams man/locale with warnings. Generate the canonical C.UTF-8 \
locale (the 'C' locale source compiled against the UTF-8 charmap, exactly \
what Debian/Fedora ship as C.UTF-8) with cross-localedef at image build \
time and install the directory tree as /usr/lib/locale/C.utf8. glibc \
resolves LANG=C.UTF-8 to that normalized name at runtime."
HOMEPAGE = "https://github.com/ra9fael/meta-impcas-util"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1-only;md5=1a6d268fd218675ffea8be556788b780"

# Only the localedata sources are used, from the same glibc release the
# target libc is built from (see glibc-version.inc in poky).
SRC_URI = "${GNU_MIRROR}/glibc/glibc-2.39.tar.xz"
SRC_URI[sha256sum] = "f77bd47cf8170c57365ae7bf86696c118adb3b120d3259c64c502d3dc1e2d926"

S = "${WORKDIR}/glibc-2.39"

DEPENDS = "cross-localedef-native"

INHIBIT_DEFAULT_DEPS = "1"

# Data-only recipe: base_do_configure would run `make clean` in the glibc
# source tree, which glibc's Makeconfig rejects.
do_configure[noexec] = "1"

do_compile() {
	treedir=${WORKDIR}/locale-tree
	rm -rf ${treedir}
	mkdir -p ${treedir}${libdir}/locale
	I18NPATH=${S}/localedata ${STAGING_BINDIR_NATIVE}/cross-localedef \
		--force --no-hard-links --no-archive \
		--uint32-align=4 --little-endian \
		--inputfile=C --charmap=UTF-8 \
		--no-warnings=ascii \
		${treedir}${libdir}/locale/C.utf8
}

do_install() {
	install -d ${D}${libdir}/locale
	cp -r --no-preserve=ownership ${WORKDIR}/locale-tree${libdir}/locale/C.utf8 ${D}${libdir}/locale/C.utf8
}

FILES:${PN} = "${libdir}/locale/C.utf8"

# The LC_* locale files are target-endian mmap data, not ELF binaries.
INSANE_SKIP:${PN} += "arch"
