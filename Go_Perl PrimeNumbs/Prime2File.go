package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func isPrime(num int) string {
	if num < 2 {
		return "\n"
	}

	sq_root := int(math.Sqrt(float64(num)))
	for i := 2; i <= sq_root; i++ {
		if num%i == 0 {
			return "\n"
		}
	}
	return " => is Prime\n"
}

func main() {
	file, err := os.Open("Numbers.txt")
	check(err)

	defer file.Close()

	writefile, err := os.Create("Results.txt")
	check(err)
	defer writefile.Close()

	var finalresults string = ""

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		number, err := strconv.Atoi(scanner.Text())
		check(err)
		concatenated := fmt.Sprintf("%d%s", number, isPrime(number))
		finalresults = fmt.Sprintf("%s%s", finalresults, concatenated)
	}
	error := os.WriteFile("Results.txt", []byte(finalresults), 0644)
	check(error)
}
