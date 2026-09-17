# zoxide (meta-impcas-util cli-env)
if [ -n "$BASH_VERSION" ] && command -v zoxide >/dev/null 2>&1; then
    eval "$(zoxide init bash)"
fi
