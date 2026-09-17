SUMMARY = "yazi - prebuilt CLI tool"
DESCRIPTION = "yazi installed from the upstream GitHub release binary \
(sxyazi/yazi). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/sxyazi/yazi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://yazi-LICENSE;md5=9c0ba340a238122a2eb7974c71bf7ae4"

# Prebuilt aarch64/x86_64 release assets only (no arm32 upstream).
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/sxyazi/yazi/releases/download/v26.9.1/yazi-aarch64-unknown-linux-musl.zip;name=bin;subdir=bin \
           https://github.com/sxyazi/yazi/releases/download/v26.9.1/yazi-x86_64-unknown-linux-musl.zip;name=binx86;subdir=binx86 \
           https://raw.githubusercontent.com/sxyazi/yazi/v26.9.1/LICENSE;name=lic;downloadfilename=yazi-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "dd569daecaae914185f295634109295ccd25c1b42b02eb89a74f651970024f2e"
SRC_URI[lic.md5sum] = "9c0ba340a238122a2eb7974c71bf7ae4"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "yazi:yazi ya:ya"
