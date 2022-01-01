# InstagramMediaDownloader
Download photos and videos of Instagram public account with help of Bibliogram

# Prerequisites
- Wget https://eternallybored.org/misc/wget/
- IDM https://www.internetdownloadmanager.com/
- Bibliogram https://git.sr.ht/~cadence/bibliogram-docs/tree/master/docs/Instances.md

# Steps
- Go to https://git.sr.ht/~cadence/bibliogram-docs/tree/master/docs/Instances.md
- Click one of the addresses you like
- Enter the username in that page (sometimes it may say Quota Reached or Blocked by Instagram, try another address instead)
- Scroll to the very bottom until all posts are shown
- Open the page source
- Extract the code of the post (usually 11 digits, letters, and numbers combined)
- Format the code into a link like this (https://bibliogram.pussthecat.org/p/*EXTRACTED_CODE*), a new line for a new post
- Save it as link.txt
- Execute the code `wget --content-disposition --trust-server-names -i "link.txt"`, this code downloads the HTML source of the post which contains all photos/videos download link
- Move it inside `/html` folder
- Run the application
- Nothing will be shown but 2 files `file.txt` contains all the HTML source combined and `filename.txt` contains all download links for the photos and videos
- Open IDM and copy everything inside filename.txt into it
- Wait for IDM to process

# Disclaimer
Wget may not be able to download every post and throw server error. You may download them manually. I take no responsibility for any dissatisfaction with this application. I know there is a simpler way to achieve the same goal but I am lazy to improve it as I already achieved what I want.
