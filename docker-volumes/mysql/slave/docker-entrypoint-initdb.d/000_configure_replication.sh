#!/bin/sh

"${mysql[@]}" -e "CHANGE MASTER TO MASTER_HOST='mysql-master', MASTER_PORT=3306, MASTER_USER='repl', MASTER_PASSWORD='repl', MASTER_AUTO_POSITION=1;"
"${mysql[@]}" -e "START SLAVE;"
