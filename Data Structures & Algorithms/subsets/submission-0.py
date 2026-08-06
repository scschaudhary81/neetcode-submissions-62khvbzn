class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:


        sub_sets: List[List[int]] = []

        def calculate_sub(index,current_list : List[int],nums: List[int]):
            if index == len(nums):
                sub_sets.append(list(current_list))
            else:
                current_list.append(nums[index])
                calculate_sub(index+1,current_list,nums)
                current_list.pop()
                calculate_sub(index+1,current_list,nums)
        

        calculate_sub(0,[],nums)

        return sub_sets



        