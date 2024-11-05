import { privateApi } from "../api/api"
import { useInfiniteQuery } from "@tanstack/react-query";

const axiosReviews = async (page) => {
    try {
        const response = await privateApi.get(`/mypage/Review?page=${page}`); // API 요청
        return response.data;
    } catch (error) {
        throw error;
    }
}

const useGetReviews = () => {
    return useInfiniteQuery({
        queryKey: ['reviews'],
        queryFn: ({ pageParam }) => {
            return axiosReviews(pageParam)
        },
        getNextPageParam: (last) => {
            if (last.page < last.totalPage) {
                return last.page + 1
            }
            return undefined;
        },
        initialPageParam: 0,
    })
}

export default useGetReviews;