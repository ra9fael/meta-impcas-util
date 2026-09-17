SUMMARY = "lazygit - prebuilt CLI tool"
DESCRIPTION = "lazygit installed from the upstream GitHub release binary \
(jesseduffield/lazygit). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/jesseduffield/lazygit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://lazygit-LICENSE;md5=c84717af4c91af538327afb0bc50e319"

# Prebuilt aarch64/x86_64 release assets; upstream also publishes
# arm32 assets (see the release page) -- add SRC_URI:append:armv7a etc.
# if a 32-bit ARM machine is ever needed.
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/jesseduffield/lazygit/releases/download/v0.65.1/lazygit_0.65.1_Linux_arm64.tar.gz;name=bin;subdir=bin \
           https://github.com/jesseduffield/lazygit/releases/download/v0.65.1/lazygit_0.65.1_linux_x86_64.tar.gz;name=binx86;subdir=binx86 \
           https://raw.githubusercontent.com/jesseduffield/lazygit/v0.65.1/LICENSE;name=lic;downloadfilename=lazygit-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "49abecdf6adf4f2dfdb11bf7b9bfada267ea523612ed809d1c6d87f6c04000a7"
SRC_URI[lic.md5sum] = "c84717af4c91af538327afb0bc50e319"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "lazygit:lazygit"
