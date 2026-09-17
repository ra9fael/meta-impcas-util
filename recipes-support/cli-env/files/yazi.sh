# yazi auto-cd wrapper (meta-impcas-util cli-env)
if [ -n "$BASH_VERSION" ] && command -v yazi >/dev/null 2>&1; then
    y() {
        local tmp="$(mktemp -t "yazi-cwd.XXXXXX")" cwd
        command yazi "$@" --cwd-file="$tmp"
        IFS= read -r -d '' cwd < "$tmp"
        [ "$cwd" != "$PWD" ] && [ -d "$cwd" ] && builtin cd -- "$cwd"
        rm -f -- "$tmp"
    }
fi
