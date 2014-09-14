rssify
=============================

A simple application that I needed to avoid constantly checking my favorite news websites/forums.

It automatically scrapes various web pages (currently Hacker News, Ask Hacker News and Bogleheads.org) and emits an RSS including the items that have more comments than my threshold.

When paired with feedly and feedburner, I have a consolidated view of everything, most background noise is filtered out and if I don't log in for a few days items will still pile up so I don't lose content.

The app is hosted on GAE, so in case you want to use the feeds yourself here they are:

Website | Feed link
---- | ---- 
Hacker News (>= 10 comments) | [![HackerNews10Comments](http://feeds.feedburner.com/~fc/HackerNews10Comments?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/HackerNews10Comments)
Hacker News (>= 50 comments) | [![HackerNews50Comments](http://feeds.feedburner.com/~fc/HackerNews50Comments?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/HackerNews50Comments)
Hacker News (>= 100 comments) | [![HackerNews100Comments](http://feeds.feedburner.com/~fc/HackerNews100Comments?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/HackerNews100Comments)

Website | Feed link
---- | ---- 
Ask Hacker News (>= 10 comments) | [![AskHackerNews10Comments](http://feeds.feedburner.com/~fc/AskHackerNews10Comments?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/AskHackerNews10Comments)
Ask Hacker News (>= 50 comments) | [![AskHackerNews50Comments](http://feeds.feedburner.com/~fc/AskHackerNews50Comments?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/AskHackerNews50Comments)
Ask Hacker News (>= 100 comments) | [![AskHackerNews100Comments](http://feeds.feedburner.com/~fc/AskHackerNews100Comments?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/AskHackerNews100Comments)

Website | Feed link
---- | ---- 
Bogleheads.org (>= 10 comments) | [![Bogleheads10](http://feeds.feedburner.com/~fc/Bogleheads10?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/Bogleheads10)
Bogleheads.org (>= 50 comments) | [![Bogleheads50](http://feeds.feedburner.com/~fc/Bogleheads50?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/Bogleheads50)
Bogleheads.org (>= 100 comments) | [![Bogleheads100](http://feeds.feedburner.com/~fc/Bogleheads100?bg=99CCFF&amp;fg=444444&amp;anim=0)](http://feeds.feedburner.com/Bogleheads100)

It served as a demo project on using Java on GAE, since I've never done it before.

I pulled this off in a couple hours of work so there are tons of bugs, but it works well enough for my use case.

Improvements include:

- Make the scraping in an asynchronous background worker. Since feedburner acts as a proxy and does all the caching, I don't really care.
- Save items already seen in a database, so they don't accidentally pop up again
