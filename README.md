rssify
=============================

http://gianlucaborello.github.io/rssify

A simple application that I needed to avoid constantly checking my favorite news websites/forums.

It automatically scrapes (every 30 minutes) various web pages (currently Hacker News, Ask Hacker News, Show Hacker News and Bogleheads.org) and emits an RSS including the items that have more comments than the threshold I choose.

When paired with feedly and feedburner, I have a consolidated view of everything, most background noise is filtered out and if I don't log in for a few days items will still pile up so I don't lose content.

The app is hosted on GAE, so in case you want to use the feeds yourself, here they are (please use the feedburner ones so I can keep this running in the free tier):

Hacker News (by points) | Link
---- | ---- 
HN items reaching 10 points | [![hn10points](http://feeds.feedburner.com/~fc/hn10points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn10points)
HN items reaching 50 points | [![hn50points](http://feeds.feedburner.com/~fc/hn50points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn50points)
HN items reaching 100 points | [![hn100points](http://feeds.feedburner.com/~fc/hn100points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn100points)
Ask HN items reaching 10 points | [![askhn10points](http://feeds.feedburner.com/~fc/askhn10points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn10points)
Ask HN items reaching 50 points | [![askhn50points](http://feeds.feedburner.com/~fc/askhn50points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn50points)
Ask HN items reaching 100 points | [![askhn100points](http://feeds.feedburner.com/~fc/askhn100points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn100points)
Show HN items reaching 10 points | [![showhn10points](http://feeds.feedburner.com/~fc/showhn10points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn10points)
Show HN items reaching 50 points | [![showhn50points](http://feeds.feedburner.com/~fc/showhn50points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn50points)
Show HN items reaching 100 points | [![showhn100points](http://feeds.feedburner.com/~fc/showhn100points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn100points)

Hacker News (by comments) | Link
---- | ---- 
HN items reaching 10 comments | [![hn10comments](http://feeds.feedburner.com/~fc/hn10comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn10comments)
HN items reaching 50 comments | [![hn50comments](http://feeds.feedburner.com/~fc/hn50comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn50comments)
HN items reaching 100 comments | [![hn100comments](http://feeds.feedburner.com/~fc/hn100comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn100comments)
Ask HN items reaching 10 comments | [![askhn10comments](http://feeds.feedburner.com/~fc/askhn10comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn10comments)
Ask HN items reaching 50 comments | [![askhn50comments](http://feeds.feedburner.com/~fc/askhn50comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn50comments)
Ask HN items reaching 100 comments | [![askhn100comments](http://feeds.feedburner.com/~fc/askhn100comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn100comments)
Show HN items reaching 10 comments | [![showhn10comments](http://feeds.feedburner.com/~fc/showhn10comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn10comments)
Show HN items reaching 50 comments | [![showhn50comments](http://feeds.feedburner.com/~fc/showhn50comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn50comments)
Show HN items reaching 100 comments | [![showhn100comments](http://feeds.feedburner.com/~fc/showhn100comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn100comments)

Bogleheads.org | Link
---- | ---- 
Posts reaching 10 comments | [![bogleheads10](http://feeds.feedburner.com/~fc/bogleheads10?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/bogleheads10)
Posts reaching 50 comments | [![bogleheads50](http://feeds.feedburner.com/~fc/bogleheads50?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/bogleheads50)
Posts reaching 100 comments) | [![bogleheads100](http://feeds.feedburner.com/~fc/bogleheads100?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/bogleheads100)

It served as a demo project on using Java on GAE, since I've never done it before. Data is saved by a background worker into the NoSQL Google database, and read from there.

I pulled this off in a very short time so there are tons of bugs, but it works well enough for my use case.
