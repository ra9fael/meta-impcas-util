SUMMARY = "lnav - prebuilt CLI tool"
DESCRIPTION = "lnav installed from the upstream GitHub release binary \
(tstack/lnav). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/tstack/lnav"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://lnav-LICENSE;md5=05dd7540deff37eb6920794d5a99181b"

# Prebuilt aarch64/x86_64 release assets only (no arm32 upstream).
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/tstack/lnav/releases/download/v0.14.1/lnav-0.14.1-linux-musl-arm64.zip;name=bin;subdir=bin \
           https://raw.githubusercontent.com/tstack/lnav/v0.14.1/LICENSE;name=lic;downloadfilename=lnav-LICENSE;subdir=lic \
"
SRC_URI:append:x86-64 = " https://github.com/tstack/lnav/releases/download/v0.14.1/lnav-0.14.1-linux-musl-x86_64.zip;name=binx86;subdir=binx86 \ "
SRC_URI[binx86.sha256sum] = "ec1750f0a6962eed6bb85ad4249457894f190e961277c56d69c47eecce9e705e"
SRC_URI[bin.sha256sum] = "e605ac855af193b5c7201e2fd94372febec931c5721b50fdf828b3e5af90c677"
SRC_URI[lic.md5sum] = "05dd7540deff37eb6920794d5a99181b"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "lnav:lnav"
