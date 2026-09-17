SUMMARY = "bat - prebuilt CLI tool"
DESCRIPTION = "bat installed from the upstream GitHub release binary \
(sharkdp/bat). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/sharkdp/bat"
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://bat-LICENSE-MIT;md5=c46eaa1315aaa0c727a29b157ad9170a"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/sharkdp/bat/releases/download/v0.26.1/bat-v0.26.1-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/sharkdp/bat/v0.26.1/LICENSE-MIT;name=lic;downloadfilename=bat-LICENSE-MIT;subdir=lic \
"
SRC_URI[bin.sha256sum] = "422eb73e11c854fddd99f5ca8461c2f1d6e6dce0a2a8c3d5daade5ffcb6564aa"
SRC_URI[lic.md5sum] = "c46eaa1315aaa0c727a29b157ad9170a"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "bat:bat"
