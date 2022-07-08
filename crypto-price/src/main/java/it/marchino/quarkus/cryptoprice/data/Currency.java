package it.marchino.quarkus.cryptoprice.data;

import javax.json.bind.annotation.JsonbProperty;

public class Currency {
	private String id;
	private String symbol;
	private String name;
	@JsonbProperty("price_usd")
	private String priceUsd;
	@JsonbProperty("price_btc")
	private String priceBtc;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the priceUsd
	 */
	public String getPriceUsd() {
		return priceUsd;
	}
	/**
	 * @param priceUsd the priceUsd to set
	 */
	public void setPriceUsd(String priceUsd) {
		this.priceUsd = priceUsd;
	}
	/**
	 * @return the priceBtc
	 */
	public String getPriceBtc() {
		return priceBtc;
	}
	/**
	 * @param priceBtc the priceBtc to set
	 */
	public void setPriceBtc(String priceBtc) {
		this.priceBtc = priceBtc;
	}

}
