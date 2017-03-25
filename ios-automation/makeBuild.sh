# List commits with comments that are new since last tag and format HTML for wiki
git_log_text=$(git log --pretty=oneline --abbrev-commit `git describe --tags --abbrev=0`.. | sed -e :a -e '$!N;s/\n/<br \/>/;ta')
git_log_text=`echo $git_log_text | perl -pe 's!((IPH|IPAD|AIOS|AAI|IPHCON)-[0-9]+)!<a href="https://jira.ccrd.clearchannel.com/browse/\1">\1</a>!gi'`
git_log_text=`echo $git_log_text | perl -pe 's!(#([0-9]+))!<a href="https://github.com/iheartradio/ios-flagship/pull/\2">\1</a>!gi'`
if [ -z "$git_log_text" ]; then
  git_log_text="No additional flagship commits"
fi
cat > $WORKSPACE/gitlog <<HTML_GIT_LOG
<div style="margin-left: 4em;">
$git_log_text
</div>
HTML_GIT_LOG
