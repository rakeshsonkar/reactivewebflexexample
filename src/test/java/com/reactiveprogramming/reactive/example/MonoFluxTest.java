package com.reactiveprogramming.reactive.example;




import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class MonoFluxTest {

	@Test
	public void testMono(){
		
	Mono<String>  monoString  = Mono.just("javatechie").log();
	monoString.subscribe(System.out::println);
	}
}
