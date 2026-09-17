SUMMARY = "hl - prebuilt CLI tool"
DESCRIPTION = "hl installed from the upstream GitHub release binary \
(pamburus/hl). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/pamburus/hl"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://hl-LICENSE;md5=fcede59d78ce4f38ef4ce537a1d98e33"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/pamburus/hl/releases/download/v0.36.3/hl-linux-arm64-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/pamburus/hl/v0.36.3/LICENSE;name=lic;downloadfilename=hl-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "dabffd22a0ea80b149ae6c500a9eb5b7112c280a305172e9cc3879a29bd03f65"
SRC_URI[lic.md5sum] = "fcede59d78ce4f38ef4ce537a1d98e33"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "hl:hl"
