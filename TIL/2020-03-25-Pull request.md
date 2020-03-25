## 목차
- 코드스쿼드 리뷰 방법

## 코드스쿼드 리뷰 방법
[출처 : 코드스쿼드 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

----
1. 저장소 브랜치에 자신의 github 아이디에 해당하는 브랜치가 있는지 확인한다. 브랜치가 없는 경우 마스터에게 브랜치 생성을 요청한다.
----
2. 프로젝트를 자신의 계정으로 fork한다. 저장소 우측 상단의 fork 버튼을 활용한다.

----
3. fork한 프로젝트를 자신의 컴퓨터로 clone한 후 디렉토리로 이동한다. 다만, 자신의 브런치만 clone한다. 전부 clone할 경우 브런치가 많기 때문에 복잡하다.

```
git clone -b {본인_아이디} --single-branch https://github.com/{본인_아이디}/{저장소 아이디}
ex) git clone -b javajigi --single-branch https://github.com/javajigi/java-racingcar
```

```
cd {저장소 아이디}
ex) cd java-racingcar
```
가
----
4. 기능 구현을 위한 브랜치 생성

```
git checkout -b 브랜치이름
ex) git checkout -b step1
```
----
5. 기능 구현 후 add, commit

```
git status //확인
git rm 파일명 //삭제된 파일
git add 파일명(or * 모두) // ex) git add . (변화가 있는 모든 파일 반영은 .(dot)을 사용
git commit -m "메시지" // 커밋
```

----
6. 본인 원격 저장소에 올리기

```
git push origin 브랜치이름
ex) git push origin step1
```

----
7.  github 서비스에서 pull request를 보낸다.
> pull request는 original 저장소의 브랜치(자신의 github 아이디)와 앞 단계에서 생성한 브랜치 이름을 기준으로 한다.
> pull request를 통해 피드백을 받으면 코드를 수정한 후 같은 브랜치에 add, commit, push 작업을 반복한다.
```
ex) code-squad/java-racingcar javajigi 브랜치 기준 => javajigi/java-racingcar step1
```

----
8. 리뷰어는 피드백을 마무리하고 codesquad 저장소로 merge한다.

----
9. merge를 완료했다는 통보를 받으면 브랜치 변경 및 작업 브랜치 삭제(option)한다.
```
git checkout 본인_아이디
git branch -D 삭제할_브랜치이름
ex) git checkout javajigi
ex) git branch -D step1i
```

----
10. merge한 codesquad 저장소와 동기화하기 위해 codesquad 저장소 추가(최초 한번만)
```
git remote add {저장소_별칭} base_저장소_url
ex) git remote add upstream https://github.com/code-squad/java-racingcar.git
// 위와 같이 codesquad 저장소를 추가한 후 전체 remote 저장소 목록을 본다.
git remote -v
```

----
11. codesquad 저장소에서 자기 브랜치 가져오기(또는 갱신하기)
```
git fetch upstream {본인_아이디}
ex) git fetch upstream javajigi
```

----
12. codesquad 저장소 브랜치와 동기화하기
```
git rebase upstream/본인_아이디
ex) git rebase upstream/javajigi
```

----
13. 4단계부터 다시 진행

----

### Heroku 사용법 
Heroku란 무료로 웹호스팅 해주는 사이트이다. 거의 git처럼 동작한다. 
- Heroku 가입 후 app을 생성한다. 이후 Heroku CLI를 다운
- heroku login
- app의 git을 remote로 등록 : heroku git:remote -a <<app name>> ex) hyunjun2
- git push heroku master하는데 내가 push하고 싶은 브랜치를 push 하려면 이 명령을 입력해야 한다. git push heroku step1:master
- 기존 브랜치가 있어서 git push 안될 대 git push -f heroku step1:master로 강제 push한다. 
- heroku ps:scale web=1
- heroku open 명령으로 실행
[출처 : https://victorydntmd.tistory.com/112](https://victorydntmd.tistory.com/112)
- Heroku 삭제 하기 : heroku apps:destroy 


## 동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정
[github을 기반으로한 온라인 코드 리뷰 방법](https://youtu.be/a5c9ku-_fok)

## 내 정리

1. 어떤 저장소를 포크하면 내 저장소에 그 저장소가 가져온다. 그뒤 내 컴퓨터에 clone한다. clone하면 내 로컬저장소와 원격저장소가 연결된다.
- 그 뒤 내 로컬저장소에 upstream라는 이름으로 remote 저장소를 붙인다.
git add remote upstream https://github.com/code-squad/java-pr-practice.git
그럼 로컬저장소에 origin과 upstream 저장소 2개가 생긴다.
- upstream저장소의 변경 사항을 가져오는 명령어
git fetch <원격저장소 이름> <본인 아이디> → git fetch upstream guswns1659
- fetch한 커밋을 내 로컬 저장소에 붙이는 작업
git merge <원격저장소 이름/본인 아이디> → git merge upstream/본인 아이디
- 로컬저장소의 변경 사항을 push해서 내 origin저장소를 업데이트한다.
git push origin master
- 그 뒤 로컬저장소에서 브랜치 만들어서 커밋 2개를 작업한 뒤 push한다.
git branch <브랜치이름> → git branch guswns1659
git push –set-upstream origin guswns1659
push하면 원격저장소에 브랜치가 만들어지고 업데이트 된다. 이 브랜치 업데이트를 마스터에 붙인다. 풀 리퀘스트 하기
[깃크라켄](https://www.gitkraken.com/)
