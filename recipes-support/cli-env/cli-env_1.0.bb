SUMMARY = "Shell integration and configs for the cli tools"
DESCRIPTION = "System-wide bash integration via /etc/profile.d (starship \
prompt, zoxide init, yazi auto-cd wrapper -- one file per tool, each \
guarded by command availability), and the uv package-index mirror config \
at /etc/uv/uv.toml."
HOMEPAGE = "https://github.com/ra9fael/meta-impcas-util"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://starship.sh \
           file://zoxide.sh \
           file://yazi.sh \
           file://uv.toml \
"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d ${D}${sysconfdir}/uv
    install -m 0644 ${WORKDIR}/starship.sh ${WORKDIR}/zoxide.sh \
        ${WORKDIR}/yazi.sh ${D}${sysconfdir}/profile.d/
    install -m 0644 ${WORKDIR}/uv.toml ${D}${sysconfdir}/uv/uv.toml
}

FILES:${PN} = "${sysconfdir}/profile.d/starship.sh \
               ${sysconfdir}/profile.d/zoxide.sh \
               ${sysconfdir}/profile.d/yazi.sh \
               ${sysconfdir}/uv/uv.toml \
"

RDEPENDS:${PN} = "starship zoxide uv yazi bash"
