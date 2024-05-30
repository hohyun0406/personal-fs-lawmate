package site.lawmate.lawcase.common.proxy.crawler;

import java.io.IOException;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService{
     private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    public static CrawlerServiceImpl getInstance(){return instance;}
    private CrawlerRepository repository;
    private CrawlerServiceImpl(){
        repository = CrawlerRepository.getInstance();
    }


    @Override
    public Map<String, ?> findBugsChartFromWeb(Map<String, ?> paramMap) throws IOException {
        return repository.save(paramMap);
    }

    @Override
    public Map<String, ?> findMelonChartFromWeb(Map<String, ?> paramMap) throws IOException {
        return repository.saveMelonChart(paramMap);
    }
}
