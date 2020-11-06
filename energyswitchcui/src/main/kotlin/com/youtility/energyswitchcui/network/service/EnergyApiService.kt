package com.youtility.energyswitchcui.network.service

import com.youtility.energyswitchcui.network.response.AuthResponse
import com.youtility.energyswitchcui.network.response.GetPostcodeStepResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by Mohit Rajput on 9/4/19.
 *  * Retrofit API interface for energy module APIs
 */
interface EnergyApiService {
    companion object {
        private const val SUPPLY_POSTCODE_STEP: String = "/energy/workflows/{workflowId}/steps/SupplyPostcodeStep"
    }

    @FormUrlEncoded
    @GET(SUPPLY_POSTCODE_STEP)
    fun getPostcodeStep(@Path("workflowId") workflowId: String): Observable<GetPostcodeStepResponse>
}