package com.henri.apicomics.marvel;

import java.util.Date;
import com.henri.apicomics.marvel.responses.ComicsDataResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class MarvelComicsService {
    private static final String PUBLIC_KEY = "bc9a6f41ef046ed28b81f68a37819a9a";
    private static final String PRIVATE_KEY = "2719924ff353ab627215e0c88238f144353c359e";

    private MarvelFeignClient marvelClient;

    public MarvelComicsService(MarvelFeignClient client) {
        this.marvelClient = client;
    }

    public ComicsDataResponse findComic(Integer id) {
        Long timeStamp = new Date().getTime();

        return marvelClient.getComicId(id,timeStamp,PUBLIC_KEY,buildHash(timeStamp));
    }

    public ComicsDataResponse findAllComics() {
        Long timeStamp = new Date().getTime();

        return marvelClient.getAllComics(timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }
}
