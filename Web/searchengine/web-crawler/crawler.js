const axios = require('axios');
const cheerio = require('cheerio');

async function crawl(url) {
    try {
        // Fetch the HTML content of the webpage
        const { data } = await axios.get(url);

        // Load the HTML content into cheerio
        const $ = cheerio.load(data);

        // Extract and log the title of the webpage
        const title = $('title').text();
        console.log(`Title: ${title}`);

        // Extract and log all the links on the webpage
        $('a').each((index, element) => {
            const link = $(element).attr('href');
            console.log(`Link ${index + 1}: ${link}`);
        });

    } catch (error) {
        console.error(`Error crawling ${url}: ${error.message}`);
    }
}

// Start crawling from the specified URL
const startUrl = 'https://en.wikipedia.org/wiki/Web_crawler';
crawl(startUrl);

