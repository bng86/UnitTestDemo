Feature: 哈利波特一到五冊熱潮正席捲全球，世界各地的孩子都為之瘋狂。
  出版社為了慶祝Agile Tour第一次在台灣舉辦，決定訂出極大的優惠，來回饋給為了小孩四處奔波買書的父母親們。
  定價的方式如下：
  1. 一到五集的哈利波特，每一本都是賣100元
  2. 如果你從這個系列買了兩本不同的書，則會有5%的折扣
  3. 如果你買了三本不同的書，則會有10%的折扣
  4. 如果是四本不同的書，則會有20%的折扣
  5. 如果你一次買了整套一到五集，恭喜你將享有25%的折扣
  6. 需要留意的是，如果你買了四本書，其中三本不同，第四本則是重複的，
  那麼那三本將享有10%的折扣，但重複的那一本，則仍須100元。
  你的任務是，設計一個哈利波特的購物車，能提供最便宜的價格給這些爸爸媽媽。

  Scenario: 第一集買了一本，其他都沒買，價格應為100*1=100元
    Given 打開 MainActivity
    When 買第1集1本
    When 計算價格
    Then 總共100元

  Scenario: 第一集買了一本，第二集也買了一本，價格應為100*2*0.95=190
    Given 打開 MainActivity
    When 買第1集1本
    When 買第2集1本
    When 計算價格
    Then 總共190元

  Scenario: 一二三集各買了一本，價格應為100*3*0.9=270
    Given 打開 MainActivity
    When 買第1集1本
    When 買第2集1本
    When 買第3集1本
    When 計算價格
    Then 總共270元

  Scenario: 一二三四集各買了一本，價格應為100*4*0.8=320
    Given 打開 MainActivity
    When 買第1集1本
    When 買第2集1本
    When 買第3集1本
    When 買第4集1本
    When 計算價格
    Then 總共320元

  Scenario: 一次買了整套，一二三四五集各買了一本，價格應為100*5*0.75=375
    Given 打開 MainActivity
    When 買第1集1本
    When 買第2集1本
    When 買第3集1本
    When 買第4集1本
    When 買第5集1本
    When 計算價格
    Then 總共375元

  Scenario: 一二集各買了一本，第三集買了兩本，價格應為100*3*0.9 + 100 = 370
    Given 打開 MainActivity
    When 買第1集1本
    When 買第2集1本
    When 買第3集2本
    When 計算價格
    Then 總共370元

  Scenario Outline:
    Given 打開 MainActivity
    When 買第一集<book1>本第二集<book2>本第三集<book3>本第四集<book4>本第五集<book5>本
    When 計算價格
    Then 總共<amount>元

    Examples:
      | book1 | book2 | book3 | book4 | book5 | amount |
      | 1     | 0     | 0     | 0     | 0     | 100    |
      | 1     | 1     | 0     | 0     | 0     | 190    |
      | 1     | 1     | 1     | 0     | 0     | 270    |
      | 1     | 1     | 1     | 1     | 0     | 320    |
      | 1     | 1     | 1     | 1     | 1     | 375    |
      | 1     | 1     | 2     | 0     | 0     | 370    |
