SUMMARY = "zellij - prebuilt CLI tool"
DESCRIPTION = "zellij installed from the upstream GitHub release binary \
(zellij-org/zellij). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/zellij-org/zellij"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://zellij-LICENSE;md5=b2c649e7655c23ffce7acb59c25282f0"

# Prebuilt aarch64/x86_64 release assets only (no arm32 upstream).
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/zellij-org/zellij/releases/download/v0.45.1/zellij-aarch64-unknown-linux-musl.tar.gz;name=bin;subdir=bin \
           https://github.com/zellij-org/zellij/releases/download/v0.45.1/zellij-x86_64-unknown-linux-musl.tar.gz;name=binx86;subdir=binx86 \
           https://raw.githubusercontent.com/zellij-org/zellij/v0.45.1/LICENSE.md;name=lic;downloadfilename=zellij-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "05f0802afadd53f8db9514e7cae53c9ae8432fed1b35b8294aa816ee3044a16b"
SRC_URI[lic.md5sum] = "b2c649e7655c23ffce7acb59c25282f0"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "zellij:zellij"
