RSSify
=============================

http://gianlucaborello.github.io/rssify

RSS feeds for Hacker News, Ask Hacker News, Show Hacker News and Bogleheads.org.

Content is automatically scraped every 30 minutes. The app is hosted on GAE, and in case you want to use the feeds yourself, here they are:

Hacker News (by points) | Link
---- | ---- 
HN - 10+ points | [![hn10points](http://feeds.feedburner.com/~fc/hn10points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn10points)
HN - 50+ points | [![hn50points](http://feeds.feedburner.com/~fc/hn50points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn50points)
HN - 100+ points | [![hn100points](http://feeds.feedburner.com/~fc/hn100points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn100points)
Ask HN - 10+ points | [![askhn10points](http://feeds.feedburner.com/~fc/askhn10points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn10points)
Ask HN - 50+ points | [![askhn50points](http://feeds.feedburner.com/~fc/askhn50points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn50points)
Ask HN - 100+ points | [![askhn100points](http://feeds.feedburner.com/~fc/askhn100points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn100points)
Show HN - 10+ points | [![showhn10points](http://feeds.feedburner.com/~fc/showhn10points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn10points)
Show HN - 50+ points | [![showhn50points](http://feeds.feedburner.com/~fc/showhn50points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn50points)
Show HN - 100+ points | [![showhn100points](http://feeds.feedburner.com/~fc/showhn100points?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn100points)

Hacker News (by comments) | Link
---- | ---- 
HN - 10+ comments | [![hn10comments](http://feeds.feedburner.com/~fc/hn10comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn10comments)
HN - 50+ comments | [![hn50comments](http://feeds.feedburner.com/~fc/hn50comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn50comments)
HN - 100+ comments | [![hn100comments](http://feeds.feedburner.com/~fc/hn100comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/hn100comments)
Ask HN - 10+ comments | [![askhn10comments](http://feeds.feedburner.com/~fc/askhn10comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn10comments)
Ask HN - 50+ comments | [![askhn50comments](http://feeds.feedburner.com/~fc/askhn50comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn50comments)
Ask HN - 100+ comments | [![askhn100comments](http://feeds.feedburner.com/~fc/askhn100comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/askhn100comments)
Show HN - 10+ comments | [![showhn10comments](http://feeds.feedburner.com/~fc/showhn10comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn10comments)
Show HN - 50+ comments | [![showhn50comments](http://feeds.feedburner.com/~fc/showhn50comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn50comments)
Show HN - 100+ comments | [![showhn100comments](http://feeds.feedburner.com/~fc/showhn100comments?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/showhn100comments)

Bogleheads.org | Link
---- | ---- 
Posts - 10+ comments | [![bogleheads10](http://feeds.feedburner.com/~fc/bogleheads10?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/bogleheads10)
Posts - 50+ comments | [![bogleheads50](http://feeds.feedburner.com/~fc/bogleheads50?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/bogleheads50)
Posts - 100+ comments | [![bogleheads100](http://feeds.feedburner.com/~fc/bogleheads100?bg=99ccff&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/bogleheads100)

It's my first Java on GAE project. Data is saved by a background worker into the NoSQL Google database, and read from there.

I've done this in a very short amount of time so there are tons of bugs, but it works well enough for my use case.
