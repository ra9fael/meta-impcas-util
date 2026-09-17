SUMMARY = "ripgrep - prebuilt CLI tool"
DESCRIPTION = "ripgrep installed from the upstream GitHub release binary \
(BurntSushi/ripgrep). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/BurntSushi/ripgrep"
LICENSE = "MIT & Unlicense"
LIC_FILES_CHKSUM = "file://ripgrep-LICENSE-MIT;md5=8d0d0aa488af0ab9aafa3b85a7fc8e12"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/BurntSushi/ripgrep/releases/download/15.2.0/ripgrep-15.2.0-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/BurntSushi/ripgrep/15.2.0/LICENSE-MIT;name=lic;downloadfilename=ripgrep-LICENSE-MIT;subdir=lic \
"
SRC_URI[bin.sha256sum] = "a740b91c82eaf9914cfedd353572f2791cbe0162c84101ee0951058f4dcbc90d"
SRC_URI[lic.md5sum] = "8d0d0aa488af0ab9aafa3b85a7fc8e12"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "rg:rg"
