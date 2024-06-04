### JAVA-PROJECT
## ***DATA VALIDATOR***


### Hexlet tests and linter status:
[![Actions Status](https://github.com/markiMiracle/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/markiMiracle/java-project-78/actions)
[![Actions Status](https://github.com/markiMiracle/java-project-78/actions/workflows/tests.yml/badge.svg)](https://github.com/markiMiracle/java-project-72/actions)
<a href="https://codeclimate.com/github/markiMiracle/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/f12f3b7b6916421fe69b/maintainability" /></a>
<a href="https://codeclimate.com/github/markiMiracle/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/f12f3b7b6916421fe69b/test_coverage" /></a>


- ### ***About it:***
  This application validates the data. You can use and configure three schema formats.
- ### Schema Formats:  
  - StringSchema the following set of methods:
    - required()
    - contains()
    - minLength()
  - NumberSchema the following set of methods:
    - required()
    - range()
    - positive()
  - MapSchema the following set of methods:
    - required()
    - sizeof()
    - shape() : this method allows you to configure validation of values inside the map
  

## Setup

```bash
make build
```

## Run

```bash
make run
```

## Run checkstyle

```bash
make lint
```

## Run tests

```bash
make test
```
