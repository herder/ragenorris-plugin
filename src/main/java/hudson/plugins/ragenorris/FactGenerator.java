/**
 * Copyright (c) 2009 Cliffano Subagio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.ragenorris;

import com.colorfulsoftware.rss.Item;
import com.colorfulsoftware.rss.RSS;
import com.colorfulsoftware.rss.RSSDoc;

import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@link FactGenerator} provides Bruce Schneier facts.
 *
 * @author cliffano
 */
public class FactGenerator implements Serializable {

	/**
	 * Random instance.
	 */
	private static final Random RANDOM = new Random();
	public static final String SCHNEIERFACTS_URL = "http://www.schneierfacts.com/rss/random";


	private transient Logger logger = Logger.getLogger(getClass().getCanonicalName());

	/**
	 * Retrieves a random fact.
	 *
	 * @return a random fact
	 */
	public String random() {
		try {
			RSS rss = new RSSDoc().readRSSToBean(new URL(SCHNEIERFACTS_URL));
			List<Item> items = rss.getChannel().getItems();
			return items.get(RANDOM.nextInt(items.size())).getDescription().getDescription();
		}
		catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
		//return entries.get(RANDOM.nextInt(entries.size())).getDescription().getValue();
		return "Bruce Schneier knows Alice and Bob's shared secret.";
	}
}
