#!/bin/bash

echo "Checking for Pull Requests from Forks..."

# 1. Fork된 PR(isCrossRepository: true)만 필터링하여 번호 추출
# --json number,isCrossRepository : 번호와 크로스 리포지토리 여부 가져오기
# select(.isCrossRepository == true) : Fork된 저장소에서 온 것만 선택
pr_numbers=$(gh pr list --state open --json number,isCrossRepository --jq '.[] | select(.isCrossRepository == true) | .number')

# 2. PR이 없는 경우 처리
if [ -z "$pr_numbers" ]; then
  echo "No open PRs from forks found."
  exit 0
fi

# 3. 배열로 변환
readarray -t pr_nums <<< "$pr_numbers"

echo "Found ${#pr_nums[@]} PRs from forks."
echo "Target PR Numbers : ${pr_nums[@]}"

# 4. 반복문으로 Squash Merge 수행
for num in "${pr_nums[@]}"
do
    echo "Try Squash Merging PR #$num ..."
    
    # --squash : 스쿼시 머지 수행 (커밋을 하나로 합침)
    # --admin : 관리자 권한으로 강제 수행
    gh pr merge "$num" --squash --admin || echo "❌ Failed to squash merge PR #$num"
    
    sleep 1
done

echo "All process finished."
