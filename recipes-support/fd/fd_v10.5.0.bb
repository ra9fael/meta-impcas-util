SUMMARY = "fd - prebuilt CLI tool"
DESCRIPTION = "fd installed from the upstream GitHub release binary \
(sharkdp/fd). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/sharkdp/fd"
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://fd-LICENSE-MIT;md5=96713c739748a44f86272791c89ce344"

# Prebuilt aarch64/x86_64 release assets; upstream also publishes
# arm32 assets (see the release page) -- add SRC_URI:append:armv7a etc.
# if a 32-bit ARM machine is ever needed.
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/sharkdp/fd/releases/download/v10.5.0/fd-v10.5.0-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/sharkdp/fd/v10.5.0/LICENSE-MIT;name=lic;downloadfilename=fd-LICENSE-MIT;subdir=lic \
"
SRC_URI:append:x86-64 = " https://github.com/sharkdp/fd/releases/download/v10.5.0/fd-v10.5.0-x86_64-unknown-linux-gnu.tar.gz;name=binx86;subdir=binx86 \ "
SRC_URI[binx86.sha256sum] = "a1259cd129636efbc3fef123525c1b49e88fe5088c012630983c310e52fdfa95"
SRC_URI[bin.sha256sum] = "c0ee43802e3313a317c5af2f4eabd6ba13eeedd595af9775f05e18a13ac4f52c"
SRC_URI[lic.md5sum] = "96713c739748a44f86272791c89ce344"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "fd:fd"
