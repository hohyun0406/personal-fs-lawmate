import pandas as pd
from icecream import ic

class Reader:
    def csv(self, file) -> pd.DataFrame:
        return pd.read_csv(file, encoding='UTF-8', thousands=',')

    def print_dataframe(self, df):
        ic(df)

def checkfile():
    reader = Reader()
    df = reader.csv('law_data.csv')
    reader.print_dataframe(df)

# checkfile 함수 호출
checkfile()
