<template>
  <div class="w-64 flex-shrink-0 bg-white rounded-xl shadow-md p-4 mx-2 hover:shadow-xl transition-shadow">
    <img
      :src="product.imageUrl"
      :alt="product.name"
      class="h-40 w-full object-cover rounded-md"
    />
    <h3 class="text-lg font-semibold mt-3">{{ product.name }}</h3>
    <p class="text-sm text-gray-600">{{ product.description }}</p>
    <div class="mt-2 text-sm text-gray-800">
      <p><strong>Available:</strong> {{ product.quantity }} kg</p>
      <p><strong>Price:</strong> ₹{{ product.price.toFixed(2) }} / kg</p>
    </div>
  </div>
</template>

<script setup>
defineProps({
  product: Object
})
</script>
