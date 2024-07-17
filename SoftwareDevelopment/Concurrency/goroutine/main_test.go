package main

import (
	"fmt"
	"testing"
	"time"
)

func RunHelloWorld(i int) {
	fmt.Println("Hello World" + string(rune(i)))
}

// func TestCreateGoroutine(t *testing.T) {

// 	for i := 0; i < 10000; i++ {
// 		go RunHelloWorld(i)
// 	}

// 	fmt.Println("done")
// 	time.Sleep(1 * time.Minute)
// }

func TestCreateChannel(t *testing.T) {
	ch := make(chan string)

	go func() {
		time.Sleep(2 * time.Second)
		ch <- "Hello World"
	}()

	// data := <-ch
	fmt.Println(<-ch)
	close(ch)
}
