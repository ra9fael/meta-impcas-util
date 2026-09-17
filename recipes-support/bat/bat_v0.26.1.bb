SUMMARY = "bat - prebuilt CLI tool"
DESCRIPTION = "bat installed from the upstream GitHub release binary \
(sharkdp/bat). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/sharkdp/bat"
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://bat-LICENSE-MIT;md5=c46eaa1315aaa0c727a29b157ad9170a"

# Prebuilt aarch64/x86_64 release assets; upstream also publishes
# arm32 assets (see the release page) -- add SRC_URI:append:armv7a etc.
# if a 32-bit ARM machine is ever needed.
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/sharkdp/bat/releases/download/v0.26.1/bat-v0.26.1-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/sharkdp/bat/v0.26.1/LICENSE-MIT;name=lic;downloadfilename=bat-LICENSE-MIT;subdir=lic \
"
SRC_URI:append:x86-64 = " https://github.com/sharkdp/bat/releases/download/v0.26.1/bat-v0.26.1-x86_64-unknown-linux-gnu.tar.gz;name=binx86;subdir=binx86 \ "
SRC_URI[binx86.sha256sum] = "726f04c8f576a7fd18b7634f1bbf2f915c43494c1c0f013baa3287edb0d5a2a3"
SRC_URI[bin.sha256sum] = "422eb73e11c854fddd99f5ca8461c2f1d6e6dce0a2a8c3d5daade5ffcb6564aa"
SRC_URI[lic.md5sum] = "c46eaa1315aaa0c727a29b157ad9170a"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "bat:bat"
