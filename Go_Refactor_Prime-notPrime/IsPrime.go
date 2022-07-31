package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {

	file, err := os.Open("Numbers.txt")

	if err != nil {
		panic(err)
	}

	defer file.Close()

	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		line := scanner.Text()
		num, err := strconv.Atoi(line)

		if err != nil {
			panic(err)
		}

		checkPrime(num)
	}

}

func checkPrime(num int) bool {
	if num < 2 {
		fmt.Printf("%d is not a Prime Number \n", num)
		return false
	}
	for i := 2; i < num; i++ {
		if num%i == 0 {
			fmt.Printf("%d is not a Prime Number \n", num)
			return false
		}
	}
	fmt.Printf("%d is a Prime Number \n", num)
	return true
}
