SUMMARY = "television - prebuilt CLI tool"
DESCRIPTION = "television (tv) installed from the upstream GitHub release binary \
(alexpasmantier/television). Prebuilt aarch64 release assets; this tool ships \
no arm32 assets. NOTE: upstream deletes release git tags after publishing, so \
the LICENSE is taken from master."
HOMEPAGE = "https://github.com/alexpasmantier/television"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://television-LICENSE;md5=241ae36c12606a29fb1dfb73b2de245b"

# Prebuilt aarch64/x86_64 release assets only (no arm32 upstream).
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/alexpasmantier/television/releases/download/0.15.9/tv-0.15.9-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/alexpasmantier/television/master/LICENSE;name=lic;downloadfilename=television-LICENSE;subdir=lic \
"
SRC_URI:append:x86-64 = " https://github.com/alexpasmantier/television/releases/download/0.15.9/tv-0.15.9-x86_64-unknown-linux-gnu.tar.gz;name=binx86;subdir=binx86 \ "
SRC_URI[binx86.sha256sum] = "87d47d071f3c3bac939b1e9b2c63e45c299c9ad31cf8711f63dede614d0c6608"
SRC_URI[bin.sha256sum] = "78a246170c9d83bea0f0c4a3fa8c9bc5cee80bbe66d34946d06fdc5a17a2cd1a"
SRC_URI[lic.md5sum] = "241ae36c12606a29fb1dfb73b2de245b"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "tv:tv"
