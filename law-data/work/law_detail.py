import requests
import xml.etree.ElementTree as ET
import csv

# API URL
url = "https://www.law.go.kr/DRF/lawService.do?OC=hh7769&target=law&type=XML&ID=14041"

# API 요청
response = requests.get(url)
response.encoding = 'utf-8'  # 응답 인코딩 설정

# XML 파싱
root = ET.fromstring(response.text)

# "기본정보"에서 "법령 ID"와 "법령명_한글" 추출
law_id = root.find('.//법령ID').text
law_name = root.find('.//법령명_한글').text

# CSV 파일 생성
with open('administrative_law.csv', mode='w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow([
        "법령 ID", "법령명_한글", "조문키", "조문번호", "조문여부", "조문제목", 
        "조문시행일자", "조문제개정유형", "조문이동이전", "조문이동이후", 
        "조문변경여부", "조문내용", "항번호", "항제개정유형", "항내용", 
        "호번호", "호내용"
    ])
    
    # 모든 "조문" 항목 추출
    for article in root.findall('.//조문단위'):
        article_key = article.get('조문키')
        article_number = article.find('조문번호').text if article.find('조문번호') is not None else ''
        article_status = article.find('조문여부').text if article.find('조문여부') is not None else ''
        article_title = article.find('조문제목').text if article.find('조문제목') is not None else ''
        article_date = article.find('조문시행일자').text if article.find('조문시행일자') is not None else ''
        article_revision_type = article.find('조문제개정유형').text if article.find('조문제개정유형') is not None else ''
        article_prev = article.find('조문이동이전').text if article.find('조문이동이전') is not None else ''
        article_next = article.find('조문이동이후').text if article.find('조문이동이후') is not None else ''
        article_changed = article.find('조문변경여부').text if article.find('조문변경여부') is not None else ''
        article_content = article.find('조문내용').text if article.find('조문내용') is not None else ''

        # 항목 정보 추출
        for clause in article.findall('.//항'):
            clause_number = clause.find('항번호').text if clause.find('항번호') is not None else ''
            clause_revision_type = clause.find('항제개정유형').text if clause.find('항제개정유형') is not None else ''
            clause_content = clause.find('항내용').text if clause.find('항내용') is not None else ''

            # 호 정보 추출
            for item in clause.findall('.//호'):
                item_number = item.find('호번호').text if item.find('호번호') is not None else ''
                item_content = item.find('호내용').text if item.find('호내용') is not None else ''

                # CSV 파일에 행 추가
                writer.writerow([
                    law_id, law_name, article_key, article_number, article_status, 
                    article_title, article_date, article_revision_type, article_prev, 
                    article_next, article_changed, article_content, clause_number, 
                    clause_revision_type, clause_content, item_number, item_content
                ])

            # 호가 없는 항목의 경우
            if not clause.findall('.//호'):
                writer.writerow([
                    law_id, law_name, article_key, article_number, article_status, 
                    article_title, article_date, article_revision_type, article_prev, 
                    article_next, article_changed, article_content, clause_number, 
                    clause_revision_type, clause_content, '', ''
                ])

        # 항이 없는 조문 단위의 경우
        if not article.findall('.//항'):
            writer.writerow([
                law_id, law_name, article_key, article_number, article_status, 
                article_title, article_date, article_revision_type, article_prev, 
                article_next, article_changed, article_content, '', '', '', ''
            ])

print("CSV 파일이 성공적으로 생성되었습니다.")
