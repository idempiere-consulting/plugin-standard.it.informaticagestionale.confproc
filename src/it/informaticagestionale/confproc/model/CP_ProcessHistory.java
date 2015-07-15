/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2007 ADempiere, Inc. All Rights Reserved.                    *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Adempiere, Inc. 															  * 										
 * Portions created by Giorgio Cafasso are Copyright (C) 2015 .               *
 *****************************************************************************/
package it.informaticagestionale.confproc.model;

import java.sql.ResultSet;
import java.util.Properties;
import java.math.BigDecimal;

public class CP_ProcessHistory extends X_CP_ProcessHistory {
	
	/**
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param CP_ProcessHistory_ID id
	 */
	public CP_ProcessHistory (Properties ctx, int CP_ProcessHistory_ID, String trxName)
	{
		super (ctx, CP_ProcessHistory_ID, trxName);
		if (CP_ProcessHistory_ID == 0)
		{

		

		}
	}	//	CP_ProcessHistory

	
	
	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 */
	public CP_ProcessHistory (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	CP_ProcessHistory
	
	/** Parent					*/
	private CP_ProcessFlow			m_parent = null;	
	
	/**
	 * 	Set Header Info
	 *	@param CP_ProcessFlow ProcessFlow
	 */
	public void setHeaderInfo (CP_ProcessFlow ProcessFlow)
	{
		m_parent = ProcessFlow;

	}	//	setHeaderInfo
	
	/**
	 * 	Get Parent
	 *	@return parent
	 */
	public CP_ProcessFlow getParent()
	{
		if (m_parent == null)
			m_parent = new CP_ProcessFlow(getCtx(), getCP_ProcessFlow_ID(), get_TrxName());
		return m_parent;
	}	//	getParent



	/**
	 *  Parent Constructor.
	 *  @param  processFlow parent 
	 */
	public CP_ProcessHistory (CP_ProcessFlow processFlow)
	{
		this (processFlow.getCtx(), 0, processFlow.get_TrxName());
		if (processFlow.get_ID() == 0)
			throw new IllegalArgumentException("Header not saved");
		setCP_ProcessFlow_ID (processFlow.getCP_ProcessFlow_ID());	//	parent
		setCPProcessFlow(processFlow);
	}	//	AdConfProcLine



	/**
	 * 	Set Defaults from processFlow.
	 * 	Does not set Parent !!
	 * 	@param CP_ProcessFlow processFlow
	 */
	public void setCPProcessFlow (CP_ProcessFlow processFlow)
	{
		setClientOrg(processFlow);
		//
		setHeaderInfo(processFlow);	//	sets m_order
	}	//	setOrder
	
}	//	CP_ProcessFlow



