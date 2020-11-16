package com.example.data.elasticsearch.others;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;

    // @Autowired RedisTemplate<String,String> template;
    

    @GetMapping(value = "/redisson/{key}")
    public String redissonTest(@PathVariable("key") String lockKey) throws InterruptedException {
        // template.opsForValue().set(lockKey, "hello,World");
        // template..set(1, "Hello,World");
        // RedissonClient client = Redisson.create();
        // RLock lock = redissonClient.getLock(lockKey);

        // // // RLock lock = ClassSingleton.INSTANCE.getRedisson().getLock(lockKey);
        RLock lock = redissonClient.getLock(lockKey);

        lock.tryLock(10, TimeUnit.SECONDS);
        try{
            Thread.sleep(1000);
        }
        finally{
            lock.unlock();
        }

        return "已解锁";
    }

}