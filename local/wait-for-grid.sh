#!/bin/bash
# wait-for-grid.sh

set -e

cmd="$@"
attempt_counter=0
max_attempts=5

while ! curl -sSL "http://localhost:4444/wd/hub/status" 2>&1 \
        | jq -r '.value.ready' 2>&1 | grep "true" >/dev/null; do
        if [ ${attempt_counter} -eq ${max_attempts} ];then
          echo "Max attempts reached"
          break
        fi
    echo 'Waiting for the Grid'
    sleep 2
    attempt_counter=$(($attempt_counter+1))
done

>&2 echo "Selenium Grid is up - executing tests"
exec $cmd