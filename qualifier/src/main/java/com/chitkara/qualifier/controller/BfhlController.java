package com.chitkara.qualifier.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    private final String EMAIL = "khushi1955.be23@chitkara.edu.in";

    // ✅ Fibonacci
    @GetMapping("/fib")
    public Map<String, Object> fib(@RequestParam int n) {
        List<Integer> fib = new ArrayList<>();
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            fib.add(a);
            int c = a + b;
            a = b;
            b = c;
        }

        Map<String, Object> res = new HashMap<>();
        res.put("data", fib);
        res.put("official_email", EMAIL);
        res.put("is_success", true);
        return res;
    }

    // ✅ Prime
    @GetMapping("/prime")
    public Map<String, Object> prime(@RequestParam List<Integer> nums) {
        List<Integer> primes = new ArrayList<>();

        for (int n : nums) {
            if (n < 2) continue;
            boolean isPrime = true;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(n);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("data", primes);
        res.put("official_email", EMAIL);
        res.put("is_success", true);
        return res;
    }

    // ✅ HCF
    @GetMapping("/hcf")
    public Map<String, Object> hcf(@RequestParam List<Integer> nums) {
        int result = nums.get(0);
        for (int n : nums) {
            result = gcd(result, n);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("official_email", EMAIL);
        res.put("is_success", true);
        return res;
    }

    // ✅ LCM
    @GetMapping("/lcm")
    public Map<String, Object> lcm(@RequestParam List<Integer> nums) {
        int result = nums.get(0);
        for (int n : nums) {
            result = result * n / gcd(result, n);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("official_email", EMAIL);
        res.put("is_success", true);
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
