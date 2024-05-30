package site.lawmate.lawcase.common.proxy.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String, ?> findBugsChartFromWeb(Map<String, ?> paramMap) throws IOException ;
    Map<String, ?> findMelonChartFromWeb(Map<String, ?> paramMap) throws IOException;
}
