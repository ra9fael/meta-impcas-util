SUMMARY = "Shell integration and configs for the cli tools"
DESCRIPTION = "System-wide bash integration (yazi auto-cd wrapper, starship \
prompt, zoxide init) via /etc/profile.d, and the uv package-index mirror \
config at /etc/uv/uv.toml."
HOMEPAGE = "https://github.com/ra9fael/meta-impcas-util"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://impcas-cli.sh \
           file://uv.toml \
"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d ${D}${sysconfdir}/uv
    install -m 0644 ${WORKDIR}/impcas-cli.sh ${D}${sysconfdir}/profile.d/impcas-cli.sh
    install -m 0644 ${WORKDIR}/uv.toml ${D}${sysconfdir}/uv/uv.toml
}

FILES:${PN} = "${sysconfdir}/profile.d/impcas-cli.sh ${sysconfdir}/uv/uv.toml"

RDEPENDS:${PN} = "starship zoxide uv yazi bash"
