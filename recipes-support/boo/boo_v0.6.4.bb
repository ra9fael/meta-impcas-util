SUMMARY = "boo - prebuilt CLI tool"
DESCRIPTION = "boo installed from the upstream GitHub release binary \
(coder/boo). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/coder/boo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://boo-LICENSE;md5=16b738ddca3b083f27ebb3900805c2dd"

# Prebuilt aarch64/x86_64 release assets only (no arm32 upstream).
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/coder/boo/releases/download/v0.6.4/boo-aarch64-linux.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/coder/boo/v0.6.4/LICENSE;name=lic;downloadfilename=boo-LICENSE;subdir=lic \
"
SRC_URI:append:x86-64 = " https://github.com/coder/boo/releases/download/v0.6.4/boo-x86_64-linux.tar.gz;name=binx86;subdir=binx86 \ "
SRC_URI[binx86.sha256sum] = "a49d4e1d1fd5fce4e7c71d7fedd862ad4f070767280f73cfa736b6ef84b96bd7"
SRC_URI[bin.sha256sum] = "7df130837018ed75d7a0a0171f7b1aaae6fcf101c12a2083f94c4e566ea8a37e"
SRC_URI[lic.md5sum] = "16b738ddca3b083f27ebb3900805c2dd"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "boo:boo"
