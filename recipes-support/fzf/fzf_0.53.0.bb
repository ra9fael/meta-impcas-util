SUMMARY = "fzf - a command-line fuzzy finder"
DESCRIPTION = "Interactive Unix filter for command-line usage. Ships the \
fzf binary, the base vim plugin providing the :FZF command, and the bash \
key bindings / completion scripts activated through /etc/profile.d."
HOMEPAGE = "https://github.com/junegunn/fzf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f77823a833a556c88e2c696bdd45aac"

# The vim plugin comes from the source tree; the fzf binary is a
# per-architecture prebuilt release asset (fzf is Go). One binary tarball per
# supported architecture, selected by the arch override; add further
# architectures as separate :append lines.
SRC_URI = "git://github.com/junegunn/fzf;protocol=https;nobranch=1;branch=master \
           https://github.com/junegunn/fzf/releases/download/${PV}/fzf-${PV}-linux_arm64.tar.gz;name=bin;subdir=bin \
"
SRC_URI:append:x86-64 = " https://github.com/junegunn/fzf/releases/download/${PV}/fzf-${PV}-linux_amd64.tar.gz;name=bin;subdir=bin \
"

# tag 0.53.0 (annotated).
SRCREV = "c4a9ccd6afc3698a57a6b938ebba6d85238033e2"

SRC_URI[bin.sha256sum] = "45b4cf8db6433d45cbcb65ffa6b52fd9ea7697fff3209705331514379d94a43b"

S = "${WORKDIR}/git"

COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

# The binary is the prebuilt release asset; the source tree is only used for
# the LICENSE and the base vim plugin.
do_compile() {
    :
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/bin/fzf ${D}${bindir}/fzf

    install -d ${D}${datadir}/vim/vimfiles/plugin
    install -m 0644 ${S}/plugin/fzf.vim ${D}${datadir}/vim/vimfiles/plugin/

    # Bash key bindings (Ctrl-T / Ctrl-R / Alt-C) and ** completion, sourced
    # from /etc/profile.d for login shells. Guarded to bash: the scripts use
    # bash-only syntax and /etc/profile is also read by non-bash shells.
    install -d ${D}${sysconfdir}/profile.d ${D}${datadir}/fzf/shell
    install -m 0644 ${S}/shell/key-bindings.bash ${S}/shell/completion.bash \
        ${D}${datadir}/fzf/shell/
    cat > ${D}${sysconfdir}/profile.d/fzf.sh <<'EOS'
# fzf key bindings (Ctrl-T / Ctrl-R / Alt-C) and ** completion
if [ -n "$BASH_VERSION" ]; then
    . /usr/share/fzf/shell/key-bindings.bash
    . /usr/share/fzf/shell/completion.bash
fi
EOS
}

# The release binary ships already stripped; tell the QA check.
INSANE_SKIP:${PN} += "already-stripped"

FILES:${PN} = "${bindir}/fzf \
               ${datadir}/vim/vimfiles \
               ${datadir}/fzf/shell \
               ${sysconfdir}/profile.d/fzf.sh \
"
