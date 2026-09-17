# meta-impcas-util: shell integration for the cli tools (bash).
if [ -n "$BASH_VERSION" ]; then
    # yazi: auto-cd wrapper
    y() {
        local tmp="$(mktemp -t "yazi-cwd.XXXXXX")" cwd
        command yazi "$@" --cwd-file="$tmp"
        IFS= read -r -d '' cwd < "$tmp"
        [ "$cwd" != "$PWD" ] && [ -d "$cwd" ] && builtin cd -- "$cwd"
        rm -f -- "$tmp"
    }
    # starship prompt
    command -v starship >/dev/null 2>&1 && eval "$(starship init bash)"
    # zoxide
    command -v zoxide >/dev/null 2>&1 && eval "$(zoxide init bash)"
fi
