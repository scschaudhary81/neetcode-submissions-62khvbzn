/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    HashSet<String> visitedUrls = new HashSet<>();

    String getHostFromUrl(String url){
        return "http://"+url.split("//")[1].split("/")[0];
    }
    public void dfs(String url,String previousHost,HtmlParser htmlParser){
        String currentHost = getHostFromUrl(url);
        if(!previousHost.isBlank() && !currentHost.equals(previousHost)) return; // if prevHost was matching
        if(visitedUrls.contains(url)) return; // if already visited this url
        else{
            visitedUrls.add(url); // add url in memory to avoid revisiting
            for(String next : htmlParser.getUrls(url)){
                dfs(next,currentHost,htmlParser); // move to next if on same host
            }
        }
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        dfs(startUrl,"",htmlParser);
        return new ArrayList(visitedUrls);
    }
}
