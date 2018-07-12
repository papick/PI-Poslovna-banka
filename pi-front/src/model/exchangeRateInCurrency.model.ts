export class ExchangeRateInCurrencyModel {
  constructor(public idExchangeRate: any,
              public primaryCurrency: string,
              public toOtherCurrency: string,
              public buying: string,
              public middle: string,
              public sell: string,
  ) {}
}
