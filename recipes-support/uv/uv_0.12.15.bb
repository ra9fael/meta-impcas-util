SUMMARY = "uv - prebuilt CLI tool"
DESCRIPTION = "uv installed from the upstream GitHub release binary \
(astral-sh/uv). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/astral-sh/uv"
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://uv-LICENSE-MIT;md5=45674e482567aa99fe883d3270b11184"

# Prebuilt aarch64/x86_64 release assets; upstream also publishes
# arm32 assets (see the release page) -- add SRC_URI:append:armv7a etc.
# if a 32-bit ARM machine is ever needed.
COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

SRC_URI = "https://github.com/astral-sh/uv/releases/download/0.12.15/uv-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://github.com/astral-sh/uv/releases/download/0.12.15/uv-x86_64-unknown-linux-gnu.tar.gz;name=binx86;subdir=binx86 \
           https://raw.githubusercontent.com/astral-sh/uv/0.12.15/LICENSE-MIT;name=lic;downloadfilename=uv-LICENSE-MIT;subdir=lic \
"
SRC_URI[bin.sha256sum] = "0e9a3499b0587d449c9ff684c0160da607826e4af1cee220bc87f378702d3e08"
SRC_URI[lic.md5sum] = "45674e482567aa99fe883d3270b11184"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "uv:uv uvx:uvx"
