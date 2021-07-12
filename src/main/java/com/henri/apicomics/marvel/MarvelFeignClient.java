package com.henri.apicomics.marvel;

import com.henri.apicomics.marvel.responses.ComicsDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="results", url = "${url.marvel}/v1/public")
public interface MarvelFeignClient {

    @GetMapping("/comics/{id}")
    ComicsDataResponse getComicId(@PathVariable Integer id,
                                  @RequestParam(value = "ts") Long timeStamp,
                                  @RequestParam(value = "apikey") String publicKey,
                                  @RequestParam(value = "hash") String hashMD5);

    @GetMapping("/comics")
    ComicsDataResponse getAllComics(@RequestParam(value = "ts") Long timeStamp,
                                    @RequestParam(value = "apikey") String publicKey,
                                    @RequestParam(value = "hash") String hashMD5);
}