#!/bin/sh

"${mysql[@]}" -e "CREATE USER 'repl'@'%' IDENTIFIED BY 'repl'"
"${mysql[@]}" -e "GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%'"
