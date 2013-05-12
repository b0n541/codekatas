package net.b0n541.codekata.romannumbers.take0005

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Trying to test with the Spock framework
 */
class RomanNumberConverterSpec extends Specification {

	RomanNumberConverter converter = new RomanNumberConverter();

	def "converter is available"() {
		expect: converter
	}

	@Unroll
	def "convert #digit to #result"() {
		expect: converter.convert(digit) == result

		where:
		digit | result
		"I"   | 1
		"V"   | 5
		"X"   | 10
		"L"   | 50
		"C"   | 100
		"D"   | 500
		"M"   | 1000
	}

	@Unroll
	def "convert #multipledigit to #result"() {
		expect: converter.convert(multipledigit) == result

		where:
		multipledigit     | result
		"II"              | 2
		"MDCLXVI"         | 1666
		"MMMDCCCLXXXVIII" | 3888 // biggest number possible
	}

	@Unroll
	def "convert #numberWithSubstraction to #result"() {
		expect: converter.convert(numberWithSubstraction) == result

		where:
		numberWithSubstraction | result
		"IV"                   | 4
		"IX"                   | 9
		"XL"                   | 40
		"XC"                   | 90
		"CD"                   | 400
		"CDXLIV"               | 444
		"CM"                   | 900
		"CMXCIX"               | 999
	}

	@Unroll
	def "convert #complexNumber to #result"() {
		expect: converter.convert(complexNumber) == result

		where:
		complexNumber | result
		"MCMLXXVII"   | 1977
		"MCMLXXXIV"   | 1984
	}
}
