# chatgpt-embedding-similarity

ChatGPT Embedding 코사인 유사도를 측정하는 Java Maven 예제 프로젝트입니다.

## Maven 빌드:

프로젝트 디렉토리에서 다음 명령을 실행하여 Maven 프로젝트를 빌드하세요.

```bash
./mvnw clean install
```

빌드를 성공적으로 완료하면, `target` 디렉토리에 JAR 파일이 생성됩니다.


## JAR 파일 실행:

빌드가 완료되면, 생성된 JAR 파일을 실행하여 `page_embeddings.json`과 `input_embedding.json` 파일의 코사인 유사도를 계산할 수 있습니다. 다음과 같이 JAR 파일을 실행하세요.

```bash
java -jar target/my-cosine-similarity-project-1.0-SNAPSHOT.jar gpt/page_embeddings.json gpt/input_embedding.json
```

이제 이 코드를 사용하여 입력된 JSON 파일에 대한 코사인 유사도를 계산할 수 있습니다. 필요한 경우 코드를 수정하여 추가 기능을 구현하세요.

## 결과
```bash
gpt/test/page_embeddings.json
gpt/test/input_embedding.json
Cosine similarity between input and page1.txt: 0.8437019406338282
Cosine similarity between input and page2.txt: 0.8227343059896893
Cosine similarity between input and page3.txt: 0.7883895187393262
Cosine similarity between input and page4.txt: 0.7232376661913258
```

